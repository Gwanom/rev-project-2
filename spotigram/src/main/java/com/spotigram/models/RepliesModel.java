package com.spotigram.models;

public class RepliesModel {
    private int sg_reply_id;
    private int parent;
    private int author;
    private String content;
    
    
	public RepliesModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RepliesModel(int sg_reply_id, int parent, int author, String content) {
		super();
		this.sg_reply_id = sg_reply_id;
		this.parent = parent;
		this.author = author;
		this.content = content;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + author;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + parent;
		result = prime * result + sg_reply_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepliesModel other = (RepliesModel) obj;
		if (author != other.author)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (parent != other.parent)
			return false;
		if (sg_reply_id != other.sg_reply_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RepliesModel [sg_reply_id=" + sg_reply_id + ", parent=" + parent + ", author=" + author + ", content="
				+ content + "]";
	}

}
