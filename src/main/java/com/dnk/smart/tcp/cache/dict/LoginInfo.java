package com.dnk.smart.tcp.cache.dict;

import com.alibaba.fastjson.JSONObject;
import com.dnk.smart.dict.Key;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * tcp login session info
 */
@Getter
@Setter
@Builder
public final class LoginInfo {
    private String sn;
    private Device device;
    private int apply;
    private int allocated;
    private long happen;

    public static LoginInfo from(@NonNull JSONObject json) {
        String sn = json.getString(Key.SN.getName());
        Device device = Device.from(json.getIntValue(Key.TYPE.getName()));
        int apply = json.getInteger(Key.APPLY.getName());
        return LoginInfo.builder().sn(sn).device(device).apply(apply).build();
    }

    public LoginInfo update(LoginInfo info) {
        if (StringUtils.hasText(info.getSn())) {
            this.setSn(info.getSn());
        }
        if (info.getDevice() != null) {
            info.setDevice(info.getDevice());
        }
        if (info.getApply() > 0) {
            info.setApply(info.getApply());
        }
        return this;
    }
}