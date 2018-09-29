package chapter_01.io;

import java.io.InputStream;

/**
 * 资源定义
 *
 * @author liuxin
 */
public interface Resource {

  /**
   * 获取输入流
   */
  InputStream getInputstream() throws Exception;
}
