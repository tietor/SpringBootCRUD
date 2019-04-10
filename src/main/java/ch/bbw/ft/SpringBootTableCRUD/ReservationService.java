package ch.bbw.ft.SpringBootTableCRUD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {

  private List<Reservation> reservations = new ArrayList<>(
      Arrays.asList(new Reservation(1, "Familie Muster, 4 Personen"), new Reservation(2, "Familie Kuster, 2 Personen"),
          new Reservation(3, "Familie Liechti, 5 Personen")));

  public List<Reservation> getAllReservations() {
    return reservations;
  }

  public Reservation getReservation(long id) {
    return reservations.stream().filter(reservation -> reservation.getId() == id).findFirst().get();
  }

  public void addReservation(Reservation value) {
    reservations.add(value);
  }

  public void updateReservation(long id, Reservation reservation) {
    reservations.stream()
        .filter(reservationObject -> reservationObject.getId() == id)
        .findFirst()
        .get()
        .setContent(reservation.getContent());
  }

  public void removeReservation(long id) {
    reservations.remove(reservations.stream().filter(reservation -> reservation.getId() == id).findFirst().get());
  }
}
