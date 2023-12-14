package com.prism.mr.controller;

import com.prism.mr.dto.AssignMemberPermissionDto;
import com.prism.mr.dto.MemberPermissionDto;
import com.prism.mr.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("/member/{memberId}/permission")
    public AssignMemberPermissionDto assignPermission(@PathVariable Long memberId, @RequestBody AssignMemberPermissionDto memberPermissionDto) {
        return permissionService.assignPermission(memberId, memberPermissionDto);
    }

    @GetMapping("/member/{memberId}/permission")
    public List<MemberPermissionDto> getAllPermissionForMember(@PathVariable Long memberId) {
        return permissionService.getAllPermissionForMember(memberId);
    }

    @GetMapping("/member/{memberId}/permission/all")
    public List<MemberPermissionDto> getAllPermission(@PathVariable Long memberId) {
        return permissionService.getAllPermission(memberId);
    }

}
