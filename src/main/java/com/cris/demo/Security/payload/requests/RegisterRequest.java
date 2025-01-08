package com.cris.demo.Security.payload.requests;

//import com.cris.demo.Models.Types.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String full_name;
    private String username;
    private String password;
    private String role;

}
