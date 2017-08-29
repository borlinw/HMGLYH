package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

public class HtglMjlx implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;

    private String typecode;

    private String key;
    private String value;
    
    // 非 持久化字段
    private boolean selected = false;
    
    public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "HtglMjlx [type=" + type + ", typecode=" + typecode + ", key="
				+ key + ", value=" + value + "]";
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}