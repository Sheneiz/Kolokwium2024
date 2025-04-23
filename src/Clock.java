import java.time.LocalTime;

    public abstract class Clock {
        private int hour;
        private int minute;
        private int second;

        public void setCurrentTime() {
            LocalTime now = LocalTime.now();
            this.hour = now.getHour();
            this.minute = now.getMinute();
            this.second = now.getSecond();
        }

        public void setTime(int hour, int minute, int second) {
            if (hour < 0 || hour > 23) {
                throw new IllegalArgumentException("Hour must be between 0 and 23.");
            }
            if (minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Minute must be between 0 and 59.");
            }
            if (second < 0 || second > 59) {
                throw new IllegalArgumentException("Second must be between 0 and 59.");
            }
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", hour, minute, second);
        }

        protected int getHour() {
            return hour;
        }

        protected int getMinute() {
            return minute;
        }

        protected int getSecond() {
            return second;
        }
    }