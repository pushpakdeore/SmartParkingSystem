package com.example.smartparking.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO
{
   // @NotNull(message = "User  ID cannot be null")
    private Long userId;

   // @NotNull(message = "Slot ID cannot be null")
    private Long slotId;

    //@NotNull(message = "Vehicle number cannot be null")
    private String vehicleNumber;

   // @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

   // @NotNull(message = "End time cannot be null")
    private LocalDateTime endTime;
}
