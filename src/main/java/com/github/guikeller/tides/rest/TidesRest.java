package com.github.guikeller.tides.rest;

import com.github.jtides.api.TideApi;
import com.github.jtides.models.TimedValue;
import com.github.jtides.util.StationTreeNode;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TidesRest {

    private final static TideApi TIDE_API = new TideApi();

    /**
     * All tide stations available
     * @return List<String>
     */
    @GetMapping("/api/open-tides/tideStations")
    public List<String> getTideStations() {
        return TIDE_API.getStations();
    }

    /**
     * All tide stations available in a tree format
     * See: https://github.com/guikeller/tides
     * @return Map<String, StationTreeNode>
     */
    @GetMapping("/api/open-tides/tideStationsTree")
    public Map<String, StationTreeNode> getTideStationsTree() {
        return TIDE_API.getStationsTree();
    }

    /**
     * Tides for a location for all hours of the day
     * @param tideStation from "/tideStations" or "/tideStationsTree"
     * @param tideDate format is 'YYYY-MM-DD'
     * @return List<TimedValue>
     */
    @GetMapping("/api/open-tides/hourlyTides")
    public List<TimedValue> getHourlyTides(@RequestParam("tideStation") String tideStation, @RequestParam("tideDate") String tideDate) {
        try {
            LocalDate localDate = LocalDate.parse(tideDate, DateTimeFormatter.ISO_DATE);
            return TIDE_API.getHourlyTides(tideStation, localDate);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid args: "+tideStation+" / "+tideDate, ex);
        }
    }

    /**
     * High and Low tides times for a given location for a given day
     * @param tideStation from "/tideStations" or "/tideStationsTree"
     * @param tideDate format is 'YYYY-MM-DD'
     * @return List<TimedValue>
     */
    @GetMapping("/api/open-tides/highLowTides")
    public List<TimedValue> getTideHeightAtTimeAndPlace(@RequestParam("tideStation") String tideStation, @RequestParam("tideDate") String tideDate) {
        try {
            LocalDate localDate = LocalDate.parse(tideDate, DateTimeFormatter.ISO_DATE);
            return TIDE_API.getTideHeightAtTimeAndPlace(tideStation, localDate);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid args: "+tideStation+" / "+tideDate, ex);
        }
    }

}
