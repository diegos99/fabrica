package net.guides.springboot.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author diego
 *
 */
@Document(collection = "database_sequences3")
public class PedidosDatabaseSequence {
	@Id
    private String id;

    private long seq;
/**
 * Constructor 
 */
    public PedidosDatabaseSequence() {}
/**
 * 
 * @return id
 */
    public String getId() {
        return id;
    }
/**
 * @param id
 */
    public void setId(String id) {
        this.id = id;
    }
/**
 * 
 * @return seq
 */
    public long getSeq() {
        return seq;
    }
/**
 * 
 * @param seq
 */
    public void setSeq(long seq) {
        this.seq = seq;
    }
}
