package org.model;

import lombok.Data;

@Data
public class UserInfo {

    private String email;
    private String name;
    private String gender;
    private String checkBoxVariant;
    private String radioVariant;
}