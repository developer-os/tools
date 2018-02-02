package mail.tools.enums;

import java.io.ObjectInputStream.GetField;

import javax.security.auth.PrivateCredentialPermission;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author rchen7
 *
 */
public enum ZoneIdEnum {
	MUMBAI(1,"Mumbai","GMT+05:30"),CHICAGO(2,"Chicago","GMT-06:00"),SZ(3,"Shenzhen ","GMT+08:00");
	
	private int zoneNum;
	private String zoneKey;
	private String zoneId;
	
	private ZoneIdEnum(int zoneNum,String zoneKey,String zoneId) {
		this.zoneNum=zoneNum;
		this.zoneKey=zoneKey;
		this.zoneId=zoneId;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	public String getZoneKey() {
		return zoneKey;
	}
	public String getZoneId() {
		return zoneId;
	}
	public int getZoneNum() {
		return zoneNum;
	}
	
	public static String getZoneIdByNum(int num) {
		for(ZoneIdEnum zone:ZoneIdEnum.values()) {
			if(zone.getZoneNum()==num) {
				return zone.getZoneId();
			}
		}
		return null;
	}
	public static String getZoneKeyByNum(int num) {
		for(ZoneIdEnum zone:ZoneIdEnum.values()) {
			if(zone.getZoneNum()==num) {
				return zone.getZoneKey();
			}
		}
		return null;
	}
}
