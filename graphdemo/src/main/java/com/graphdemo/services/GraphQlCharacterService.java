package com.graphdemo.services;

import com.graphdemo.QueryService;
import com.graphdemo.repositories.CharacterRepository;
import graphql.GraphQL;
import graphql.schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

import static graphql.Scalars.GraphQLBigInteger;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

@Service
public class GraphQlCharacterService implements QueryService {

    private GraphQL graphQL;

    @Autowired
    private CharacterRepository characterRepository;

    public GraphQlCharacterService() {

        GraphQLObjectType hero = newObject()
                .name("hero")
                .field(newFieldDefinition()
                        .type(GraphQLString)
                        .name("name")
                        .build())
                .field(newFieldDefinition()
                        .type(GraphQLBigInteger)
                        .name("id")
                        .build())
                .field(newFieldDefinition()
                        .type(GraphQLBigInteger)
                        .name("age")
                        .build())
                .field(newFieldDefinition()
                        .type(GraphQlList)
                        .name("friends")
                        .build())
                .build();

        GraphQLObjectType query = newObject()
                .name("query")
                .field(newFieldDefinition()
                        .type(hero)
                        .name("hero")
                        .argument(newArgument()
                                .name("id")
                                .type(GraphQLBigInteger)
                                .build())
                        .dataFetcher(new DataFetcher() {
                            @Override
                            public Object get(DataFetchingEnvironment environment) {
                                return characterRepository.findById(((BigInteger) environment.getArguments().get("id")).intValue());
                            }
                        })
                        .build())
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(query)
                .build();
        this.graphQL = new GraphQL(schema);
    }

    public Object query(String request) {
        return graphQL.execute(request).getData();
    }

    public static GraphQLScalarType GraphQlList = new GraphQLScalarType("List", "List", new Coercing() {
        @Override
        public Object serialize(Object input) {
            return input;
        }

        @Override
        public Object parseValue(Object input) {
            return null;
        }

        @Override
        public Object parseLiteral(Object input) {
            return null;
        }
    });
}
