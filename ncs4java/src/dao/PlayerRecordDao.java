package dao;

import entities.Member;
import entities.PlayerAVG;

public interface PlayerRecordDao {

	PlayerAVG playeravgSelectOne(String team);
	int playeravgInsert(PlayerAVG data);
	
}
