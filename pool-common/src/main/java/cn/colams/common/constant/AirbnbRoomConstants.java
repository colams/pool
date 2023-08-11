package cn.colams.common.constant;

public class AirbnbRoomConstants {

    public interface DealStatus {
        /**
         * 待处理
         */
        int WAITING_PROCESS = 0;
        /**
         * 处理成功
         */
        int PROCESS_SUCCESS = 1;
        /**
         * 处理失败，待重试
         */
        int PROCESS_FAILED = 2;
        /**
         * 无需处理，已存在房东信息
         */
        int NO_NEED_PROCESS = 3;
        /**
         * 房源已经下架，无法查看
         */
        int ROOM_FORBIDDEN = 4;
        /**
         * 需要人工介入处理
         */
        int MANUAL_PROCESS = 5;
    }

}
