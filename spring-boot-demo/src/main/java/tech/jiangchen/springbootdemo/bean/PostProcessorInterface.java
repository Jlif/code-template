package tech.jiangchen.springbootdemo.bean;

/**
 * @author jiangchen
 * @date 2021/07/09
 */
public interface PostProcessorInterface {
    String getEncodeString();

    void setDecode(String password);
}
