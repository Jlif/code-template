package tech.jiangchen.springbootdemo.bean;

/**
 * @author jiangchen
 * @date 2021/07/09
 */
public class DemoBean implements PostProcessorInterface {

    private String password;

    public DemoBean(String password) {
        this.password = password;
    }

    @Override
    public String getEncodeString() {
        return this.password;
    }

    @Override
    public void setDecode(String password) {
        this.password = password;
    }
}
