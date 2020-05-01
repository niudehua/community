package cn.niudehua.community.service;

import cn.niudehua.community.dto.PaginationDTO;
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
     * @param page 当前页数
     * @param size 每页数据条数
     * @return List<QuestionDTO>
     */
    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        // 查出总条数
        Integer totalCount = questionMapper.count();
        // 设置分页相关属性
        paginationDTO.setPagination(totalCount, page, size);
        // 判断page容错 小于1时设置为1，大于总页数时设置为总页数
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        // limit查询
        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.list(offset, size);
        //关联user表查询
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            // 通过Question中的creator字段查询出相关联的User封装到QuestionDTO中
            User user = userMapper.findById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setData(questionDTOS);
        return paginationDTO;
    }

    /**
     * 查询指定用户展示到个人资料页面-我的问题
     *
     * @param userId creator 当前用户
     * @param page   当前页数
     * @param size   每页数据条数
     * @return List<QuestionDTO>
     */
    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        // 查出总条数
        Integer totalCount = questionMapper.countByCreator(userId);
        // 设置分页相关属性
        paginationDTO.setPagination(totalCount, page, size);
        // 判断page容错 小于1时设置为1，大于总页数时设置为总页数
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        // limit查询
        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.listByCreator(userId, offset, size);
        //关联user表查询
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            // 通过Question中的creator字段查询出相关联的User封装到QuestionDTO中
            User user = userMapper.findById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setData(questionDTOS);
        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }
}
