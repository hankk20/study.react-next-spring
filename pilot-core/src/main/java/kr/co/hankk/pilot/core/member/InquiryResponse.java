package kr.co.hankk.pilot.core.member;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InquiryResponse {

    @Builder.Default
    private final String result;
}
