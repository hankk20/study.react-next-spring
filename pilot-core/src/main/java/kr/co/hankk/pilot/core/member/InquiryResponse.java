package kr.co.hankk.pilot.core.member;


import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InquiryResponse {

    @Builder.Default
    private final String result;
}
