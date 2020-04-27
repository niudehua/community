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
 * @desc:
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionService {
    private final UserMapper userMapper;
    private final QuestionMapper questionMapper;

    public List<QuestionDTO> list() {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        List<Question> questionList = questionMapper.list();
        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            User user = userMapper.findById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
