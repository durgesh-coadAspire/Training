package com.prism.mr.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberPermissionDto {
    private Long id;
    private String name;
    private String code;
    private String permissionGroupId;
    private Long sequence;
    private boolean assigned;

    public MemberPermissionDto(Long id, String name, String code, String permissionGroupId, Long sequence) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.permissionGroupId = permissionGroupId;
        this.sequence = sequence;
    }
}
