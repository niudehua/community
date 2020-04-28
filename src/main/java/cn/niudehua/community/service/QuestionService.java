package cn.niudehua.community.service;

import cn.niudehua.community.dto.QuestionDTO;
import cn.niudehua.community.mapper.QuestionMapper;
import cn.niudehua.community.mapper.UserMapper;
import cn.niudehua.community.model.Question;
import cn.niudehua.community.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deng
 * @datetime: 2020/4/27 10:25 下午
 * @desc: 问题模型服务
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionService {
    private final UserMapper userMapper;
    private final QuestionMapper questionMapper;

    /**
     * 查询出展示到首页的QuestionDTO模型
     *
     * @return List<QuestionDTO>
     */
    public List<QuestionDTO> list() {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        List<Question> questionList = questionMapper.list();
        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            //通过Question中的creator字段查询出相关联的User封装到QuestionDTO中
            User user = userMapper.findById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
