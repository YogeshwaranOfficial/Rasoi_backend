package com.cheflancer.backend.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    /**
     * Logic: Uploads file and returns a Parameterized Map to fix Raw Type warning.
     */
    // Logic: Now we can pass "profiles/customers" or "foods/chef_dishes"
public Map<String, Object> uploadImage(MultipartFile file, String subPath) throws IOException {
    @SuppressWarnings("unchecked")
    Map<String, Object> uploadResult = (Map<String, Object>) cloudinary.uploader().upload(file.getBytes(), 
            ObjectUtils.asMap("folder", "rasoi_elite/" + subPath)); // Dynamically builds the path
    return uploadResult;
}

    /**
     * Logic: Deletes image using Public ID.
     */
    public Map<String, Object> deleteImage(String publicId) throws IOException {
        @SuppressWarnings("unchecked")
        Map<String, Object> deleteResult = (Map<String, Object>) cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        return deleteResult;
    }
}