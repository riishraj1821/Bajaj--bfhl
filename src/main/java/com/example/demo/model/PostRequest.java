package com.example.demo.model;
import java.util.List;
public class PostRequest {
   
    private List<String> data;  // Array of input data
    private String file_b64;    // Base64 string of the file

    // Getters and setters
    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getFile_b64() {
        return file_b64;
    }

    public void setFile_b64(String file_b64) {
        this.file_b64 = file_b64;
    }
}