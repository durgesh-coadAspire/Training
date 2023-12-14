package com.prism.mr.service;

import com.prism.mr.dto.AssignMemberPermissionDto;
import com.prism.mr.dto.MemberPermissionDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.model.MemberPermission;
import com.prism.mr.model.Permission;
import com.prism.mr.repository.MemberPermissionRepository;
import com.prism.mr.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final MemberPermissionRepository memberPermissionRepository;
    private final PermissionRepository permissionRepository;

    public AssignMemberPermissionDto assignPermission(Long memberId, AssignMemberPermissionDto memberPermissionDto) {
        try {
            memberPermissionRepository.deleteAllByMemberId(memberId);
            if (!CollectionUtils.isEmpty(memberPermissionDto.getPermissionIds())) {
                memberPermissionRepository.saveAll(memberPermissionDto.getPermissionIds().stream().map(permissionId -> new MemberPermission(permissionId,memberId)).collect(Collectors.toList()));
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error Occurred While Assigning Permission.");
        }
        return memberPermissionDto;
    }

    public List<MemberPermissionDto> getAllPermissionForMember(Long memberId) {
        return memberPermissionRepository.getAllPermissionForMember(memberId);
    }

    public List<MemberPermissionDto> getAllPermission(Long memberId) {
        List<MemberPermissionDto> assignedPermission = memberPermissionRepository.getAllPermissionForMember(memberId);
        List<Long> assignedPermissionIds = assignedPermission.stream().map(memeberPermissionDto -> {
            memeberPermissionDto.setAssigned(true);
            return memeberPermissionDto.getId();
        }).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(assignedPermissionIds)) {
            assignedPermission.addAll(permissionRepository.findAll().stream().map(PermissionService::mapToMemberPermissionDto).collect(Collectors.toList()));
        } else {
            assignedPermission.addAll(permissionRepository.findAllByIdNotIn(assignedPermissionIds).stream().map(PermissionService::mapToMemberPermissionDto).collect(Collectors.toList()));
        }
        assignedPermission.stream().sorted(Comparator.comparing(MemberPermissionDto::getPermissionGroupId).thenComparing(MemberPermissionDto::getSequence)); //Sorting by person id and then by age.
        return assignedPermission;
    }

    private static MemberPermissionDto mapToMemberPermissionDto(Permission permission) {
        MemberPermissionDto memberPermissionDto = new MemberPermissionDto();
        memberPermissionDto.setId(permission.getId());
        memberPermissionDto.setCode(permission.getCode());
        memberPermissionDto.setName(permission.getName());
        memberPermissionDto.setSequence(permission.getSequence());
        memberPermissionDto.setPermissionGroupId(permission.getPermissionGroupId());
        return memberPermissionDto;
    }
}
