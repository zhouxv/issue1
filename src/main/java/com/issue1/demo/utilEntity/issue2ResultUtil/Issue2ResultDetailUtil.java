package com.issue1.demo.utilEntity.issue2ResultUtil;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Valid
@Data
public class Issue2ResultDetailUtil {
    @NotBlank(message = "evaluation_results中的secure_group字段不能为空")
    public String secure_group;

    @NotBlank(message = "evaluation_results中的index_item字段不能为空")
    public String index_item;

    @NotNull(message = "evaluation_results中的index字段不能为null")
    @Max(value = 130, message = "evaluation_results中的index字段的值应在1-130之间")
    @Min(value = 1, message = "evaluation_results中的index字段的值应在1-130之间")
    public Integer index;

    @NotBlank(message = "evaluation_results中的level字段不能为空")
    @Pattern(message = "evaluation_results中的level字段只能为“基础定义级/增强控制级/持续优化级/量化完善级”之一", regexp = "基础定义级|增强控制级|持续优化级|量化完善级")
    public String level;

    @NotBlank(message = "evaluation_results中的conf字段不能为空")
    @Pattern(message = "evaluation_results中的conf格式为“整数1/整数2", regexp = "\\d+/\\d+")
    public String conf;
}
