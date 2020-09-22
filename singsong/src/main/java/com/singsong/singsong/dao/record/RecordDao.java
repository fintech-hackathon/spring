package com.singsong.singsong.dao.record;

import java.util.List;

import com.singsong.singsong.dto.record.Record;

public interface RecordDao {
    
    List<Record> getRecordList();
    int upLikes(String url);
    int upHites(String url);

}
