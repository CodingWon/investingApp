package com.investing.app.domain.health.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Health Check MyBatis Mapper
 *
 * MyBatis 설정 테스트용 Mapper
 */
@Mapper
public interface HealthMapper {

    /**
     * 데이터베이스 연결 테스트
     * @return 현재 시간
     */
    @Select("SELECT NOW() as `current_time`")
    Map<String, Object> checkDatabase();

    /**
     * XML 매퍼 테스트
     * @return 버전 정보
     */
    Map<String, Object> getVersion();
}
