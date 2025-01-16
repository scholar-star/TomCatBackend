package org.zerock.tomproject.todo.service;

import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.tomproject.dao.TodoDAO;
import org.zerock.tomproject.domain.TodoVO;
import org.zerock.tomproject.todo.dto.TodoDTO;
import org.zerock.tomproject.util.MapperUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2 // log4j로 로그 작성
public enum TodoService {
    INSTANCE;
    // 생성자가 private
    // singleton 가능
    private TodoDAO dao;
    private ModelMapper modelMapper;
    
    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    
    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        // TodoDTO => TodoVO
        System.out.println("todoVO: " + todoVO);
        dao.insert(todoVO); // int 반환, 예외처리도 가능
    }

    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.."+i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList());

        return todoDTOS;
    }
    

    public TodoDTO get(Long tno) throws Exception {
        log.info("tno: " + tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList.....");

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public void remove(Long tno) throws Exception {
        log.info("tno: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO: "+todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
    }
}
