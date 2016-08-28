package com.boom.chat.service;/**
 * Created by Administrator on 2016/8/28.
 */

import org.springframework.stereotype.Service;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 处理分词
 *
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
@Service
public class SplitService {


    public Set<String> splitContent(String data) throws IOException {
        if (data == null) {
            return Collections.EMPTY_SET;
        }
        Set set = new HashSet();
        StringReader re = new StringReader(data);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex = null;
        while ((lex = ik.next()) != null) {
            set.add(lex.getLexemeText());
        }
        re.close();
        return set;
    }

}
