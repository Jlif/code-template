import org.springframework.stereotype.Service;

/**
 * @author jiangchen
 * @date 2020/07/09
 */
@Service
public class AProcess implements BusinessProcess {
    @Override
    public void process(ProcessContext context) {
        Model a = context.getModel();
        //...
        context.setNeedBreak(Boolean.TRUE);
    }
}
