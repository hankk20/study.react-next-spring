package kr.co.hankk.pilot.core.member;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/member")
    public ResponseEntity getMember(@AuthenticationPrincipal(expression = "userInfo") OidcUserInfo userInfo){
        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/inquiry")
    public ResponseEntity inquiry(){
        return ResponseEntity.ok("");
    }
}
