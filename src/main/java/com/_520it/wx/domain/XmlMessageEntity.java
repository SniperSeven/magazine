package com._520it.wx.domain;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter@Setter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMessageEntity {

	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;
	private String MsgType;
	private String Content;
	private String Event;
	private Long MsgId;

	@Override
	public String toString() {
		return "XmlMessageEntity [ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", Event=" + Event + ", MsgType=" + MsgType
				+ ", Content=" + Content + ", MsgId=" + MsgId + "]";
	}

}
