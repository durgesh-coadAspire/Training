package com.prism.mr.controller;

import com.prism.mr.dto.MembersDto;
import com.prism.mr.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MembersDto> addOrUpdateMember(@RequestBody MembersDto membersDto) {
        return new ResponseEntity<>(memberService.addOrUpdateMember(membersDto), HttpStatus.OK);
    }

    @GetMapping("/members/validate/employeeId")
    public ResponseEntity<String> validateEmployeeId(@RequestParam(required = false) Long Id,@RequestParam String Code) {
        return new ResponseEntity<>(memberService.validateEmployeeId(Id,Code), HttpStatus.OK);
    }

}
