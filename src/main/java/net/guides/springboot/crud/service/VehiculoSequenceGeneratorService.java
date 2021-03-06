package net.guides.springboot.crud.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.guides.springboot.crud.model.VehiculoDatabaseSequence;

@Service
public class VehiculoSequenceGeneratorService {
	 private MongoOperations mongoOperations;
/**
 * 
 * @param mongoOperations
 */
    @Autowired
    public VehiculoSequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
/**
 * 
 * @param seqName
 * @return !Objects.isNull(counter) ? counter.getSeq() : 1;
 */
    public long generateSequence(String seqName) {

    	VehiculoDatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                VehiculoDatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}
