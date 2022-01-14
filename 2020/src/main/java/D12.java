import java.util.List;

public class D12 {

    public static Ship rotateWaypoint(Ship waypoint, int angle) {
        int x = 0;
        int y = 0;
        switch (angle % 360) {
            case 0:
                break;
            case -270:
            case 90:
                x = waypoint.y;
                y = -waypoint.x;
                break;
            case -180:
            case 180:
                x = -waypoint.x;
                y = -waypoint.y;
                break;
            case -90:
            case 270:
                x = -waypoint.y;
                y = waypoint.x;
                break;
            default:
                return null;
        }
        waypoint.x = x;
        waypoint.y = y;

        return waypoint;
    }

    public int navigate(List<String> input) {
        Ship ship = new Ship();
        ship.face = Direction.E;

        for (String inst : input) {
            char action = inst.charAt(0);
            int unit = Integer.parseInt(inst.substring(1));

            ship = navigate(ship, action, unit);
        }
        return Math.abs(ship.x) + Math.abs(ship.y);
    }

    private Ship navigate(Ship ship, char action, int unit) {
        switch (action) {
            case 'N':
                ship.y = ship.y + unit;
                break;
            case 'W':
                ship.x = ship.x - unit;
                break;
            case 'E':
                ship.x = ship.x + unit;
                break;
            case 'S':
                ship.y = ship.y - unit;
                break;
            case 'L':
                ship.face = Direction.valueOf(ship.face.angle - unit);
                break;
            case 'R':
                ship.face = Direction.valueOf(ship.face.angle + unit);
                break;
            case 'F':
                navigate(ship, ship.face.label, unit);
                break;
        }
        return ship;
    }

    public int navigateRelative(List<String> input) {
        Ship ship = new Ship();
        ship.face = Direction.E;

        Ship waypoint = new Ship();
        waypoint.x = 10;
        waypoint.y = 1;

        for (String inst : input) {
            char action = inst.charAt(0);
            int unit = Integer.parseInt(inst.substring(1));

            switch (action) {
                case 'N':
                    waypoint.y = waypoint.y + unit;
                    break;
                case 'W':
                    waypoint.x = waypoint.x - unit;
                    break;
                case 'E':
                    waypoint.x = waypoint.x + unit;
                    break;
                case 'S':
                    waypoint.y = waypoint.y - unit;
                    break;
                case 'L':
                    waypoint = rotateWaypoint(waypoint, -unit);
                    break;
                case 'R':
                    waypoint = rotateWaypoint(waypoint, unit);
                    break;
                case 'F':
                    ship.x = ship.x + unit * waypoint.x;
                    ship.y = ship.y + unit * waypoint.y;
                    break;
            }
        }
        return Math.abs(ship.x) + Math.abs(ship.y);
    }


    enum Direction {
        N('N', 0),
        E('E', 90),
        S('S', 180),
        W('W', 270);


        public final char label;
        public final int angle;

        private Direction(char label, int angle) {
            this.label = label;
            this.angle = angle;
        }

        public static Direction valueOf(int angle) {
            switch (angle % 360) {
                case 0:
                    return Direction.N;
                case 90:
                case -270:
                    return Direction.E;
                case 180:
                case -180:
                    return Direction.S;
                case 270:
                case -90:
                    return Direction.W;
                default:
                    return null;
            }
        }
    }

    class Ship {
        int x;
        int y;
        Direction face;
    }
}
