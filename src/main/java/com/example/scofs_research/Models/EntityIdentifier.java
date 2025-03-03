package com.example.scofs_research.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityIdentifier implements Serializable {
    private long systemObject;
    private long id;

    public long[] getArray() {
        return new long[]{systemObject, id};
    }

    public EntityIdentifier copy() {
        return new EntityIdentifier(systemObject, id);
    }
}
