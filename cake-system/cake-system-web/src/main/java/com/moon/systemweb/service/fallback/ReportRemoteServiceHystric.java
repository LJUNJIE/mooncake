package com.moon.systemweb.service.fallback;

import com.moon.common.model.ResultData;
import com.moon.reportapi.dto.ReportDto;
import com.moon.systemweb.service.feign.ReportRemoteService;
import org.springframework.stereotype.Component;

@Component
public class ReportRemoteServiceHystric implements ReportRemoteService {
    @Override
    public ResultData getReport(ReportDto reportDto) {
        ResultData resultData = new ResultData(999,"远程访问异常");
        return resultData;
    }
}
