package com.demo.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

@Entity
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private byte[] bytes;

    @Column
    private String base64;


    public Image(byte[] bytes) {
        this.bytes = bytes;
        this.base64 = Base64.getMimeEncoder().encodeToString(bytes);
    }

    public Image(String base61Encoded) throws IOException {
        base61Encoded = base61Encoded.replace("\\", "");
        this.base64 = base61Encoded;
        bytes = Base64.getMimeDecoder().decode(base61Encoded);
    }

    @JsonIgnore
    public BufferedImage getBufferedImage() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        inputStream.close();
        return bufferedImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
