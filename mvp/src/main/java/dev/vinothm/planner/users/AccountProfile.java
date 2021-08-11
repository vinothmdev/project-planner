package dev.vinothm.planner.users;

import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * User Account Profile
 * Help manage user account and profile in app
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountProfile {

   @GetMapping("/profile")
   public String profile() {
      return "Profile receive";
   }

   @PutMapping("/profile")
   public String updateProfile() {
      return "Profile update";
   }

   @DeleteMapping("/profile")
   public String deleteProfile() {
      return "Profile Delete";
   }

   @PostMapping("/profile")
   public String createProfile() {
      return "Profile Create";
   }

}