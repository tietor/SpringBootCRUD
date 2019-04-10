package ch.bbw.ft.SpringBootTableCRUD;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

  private ReservationService reservations;

  public ReservationController(ReservationService reservations) {
    this.reservations = reservations;
  }

  @GetMapping("/list-reservations")
  public String listReservation(Model model) {
    model.addAttribute("listOfReservations", reservations.getAllReservations());
    return "reservationlist";
  }

  @GetMapping("/add-reservation")
  public String addReservation(Model model) {
    model.addAttribute("reservation", new Reservation());
    return "addreservation";
  }

  @PostMapping("/add-reservation")
  public String addReservation(Reservation reservation, Model model) {
    reservations.addReservation(reservation);
    model.addAttribute("listOfReservations", reservations.getAllReservations());
    return "reservationlist";
  }

  @GetMapping("/edit-reservation/{id}")
  public String editReservation(@PathVariable("id") long id, Model model) {
    Reservation value = reservations.getReservation(id);
    model.addAttribute("reservation", value);
    return "editreservation";
  }

  @PostMapping("/edit-reservation")
  public String editReservation(Reservation reservation, Model model) {
    reservations.updateReservation(reservation.getId(), reservation);
    model.addAttribute("listOfReservations", reservations.getAllReservations());
    return "reservationlist";
  }

  @GetMapping("/delete-reservation")
  public String deleteReservation(@RequestParam(name = "id", required = true) long id, Model model) {
    reservations.removeReservation(id);
    model.addAttribute("listOfReservations", reservations.getAllReservations());
    return "reservationlist";
  }
}
