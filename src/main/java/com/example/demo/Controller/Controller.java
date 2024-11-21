package com.example.demo.Controller;

import com.example.demo.model.GetResponse;
import com.example.demo.model.PostRequest;
import com.example.demo.model.PostResponse;
import com.example.demo.util.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/bfhl")
public class Controller {

    @PostMapping
    public ResponseEntity<PostResponse> handlePostRequest(@RequestBody PostRequest request) {
        PostResponse response = new PostResponse();

        // Set static fields
        response.setUser_id("john_doe_17091999");
        response.setEmail("john_doe_17091999");
        response.setRoll_number("ABCD1234");

        // Process data
        List<String> numbers = Utils.extractNumbers(request.getData());
        List<String> alphabets = Utils.extractAlphabets(request.getData());
        String highestLowercase = Utils.findHighestLowercase(alphabets);

        // Check for prime numbers
        boolean isPrimeFound = numbers.stream()
                .mapToInt(Integer::parseInt)
                .anyMatch(Utils::isPrime);

        // File handling
        boolean fileValid = Utils.isFileValid(request.getFile_b64());
        String fileMimeType = fileValid ? Utils.getMimeType(request.getFile_b64()) : null;
        double fileSizeKb = fileValid ? Base64.getDecoder().decode(request.getFile_b64()).length / 1024.0 : 0;

        // Set response fields
        response.setIs_success(true);
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighest_lowercase_alphabet(highestLowercase);
        response.setIs_prime_found(isPrimeFound);
        response.setFile_valid(fileValid);
        response.setFile_mime_type(fileMimeType);
        response.setFile_size_kb(fileSizeKb);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetResponse> handleGetRequest() {
        return ResponseEntity.ok(new GetResponse(1));
    }
}
