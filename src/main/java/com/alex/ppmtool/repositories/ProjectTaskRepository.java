package com.alex.ppmtool.repositories;

import com.alex.ppmtool.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends CrudRepository <ProjectTask, Long> {

    //ProjectTask findByProjectIdentifier(String projectIdentifier);
    List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

    ProjectTask findByProjectSequence(String sequence);

}
