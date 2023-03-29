package com.abhishek.poloju.ContentCalenderRestAPI.repository;

import com.abhishek.poloju.ContentCalenderRestAPI.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList =new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll(){
        return contentList;
    }


    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }
   

     public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }


     public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

}
