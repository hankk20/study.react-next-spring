package kr.co.hankk.pilot.core.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    @GetMapping("/session")
    public ResponseEntity getMember(@AuthenticationPrincipal(expression = "userInfo") OidcUserInfo userInfo){
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/inquiry")
    public ResponseEntity inquiry(@RequestBody InquiryRequest request){
        log.debug(request.toString());
        return ResponseEntity.ok(new InquiryResponse("success"));
    }
}
