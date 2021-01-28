package com.issue1.demo.util;

import com.issue1.demo.entity.TestResult;
import com.issue1.demo.utilEntity.FormatCheckResult;

import java.util.List;

import static com.issue1.demo.util.ConvertList.convertTestResult;

public class FormatCheck {
    public static FormatCheckResult testResultFormatCheck(TestResult testResult) {
        FormatCheckResult result = new FormatCheckResult();
        result.setError(false);
        StringBuffer stringBuffer = new StringBuffer();

        List<String> stringList = convertTestResult(testResult);

        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i) == null) {
                result.setError(true);
                stringBuffer.append("指标");
                stringBuffer.append(i + 1);
                stringBuffer.append("的不能为空；");
                continue;
            }
            if (!stringList.get(i).matches("(\\d+,){7}\\d+")) {
                result.setError(true);
                stringBuffer.append("指标");
                stringBuffer.append(i + 1);
                stringBuffer.append("的测试结果格式不符合要求；");
            }
        }

        result.setErrorString(stringBuffer.toString());
        return result;
    }
}
