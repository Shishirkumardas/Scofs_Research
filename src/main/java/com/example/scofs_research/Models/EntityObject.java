package com.example.scofs_research.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityObject implements Serializable {
    /**
     * All system entity have these properties.
     */
    protected long id;
    protected String name;
    protected String description;
    protected boolean deleted;
    protected long systemObject;
}
