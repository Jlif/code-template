import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author jiangchen
 * @date 2020/07/09
 */
@Data
public class ProcessController {

    // 不同的code 对应不同的责任链
    private Map<String, ProcessTemplate> templateConfig = null;

    public void process(ProcessContext context) {
        //根据上下文的Code 执行不同的责任链
        String businessCode = context.getCode();
        ProcessTemplate processTemplate = templateConfig.get(businessCode);
        List<BusinessProcess> actionList = processTemplate.getProcessList();
        //遍历某个责任链的流程节点
        for (BusinessProcess action : actionList) {
            try {
                action.process(context);
                if (context.getNeedBreak()) {
                    break;
                }
            } catch (Exception e) {
                //...
            }
        }
    }
}
