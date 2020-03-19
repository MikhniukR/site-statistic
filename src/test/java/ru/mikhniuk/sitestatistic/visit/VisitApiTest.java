package ru.mikhniuk.sitestatistic.visit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VisitApiTest {
    private MockMvc mockMvc;

    @Mock
    private VisitService visitService;

    @InjectMocks
    private VisitApi visitApi;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(visitApi).build();
    }

    @Test
    void create() throws Exception {
        VisitInfo visitInfo = new VisitInfo("userId" , "siteUrl");
        DayStatistic dayStatistic = new DayStatistic(1, 1);
        //Can't mock visitApi.save() because visitInfo.createdAt are different
        when(visitService.getDayStatistic()).thenReturn(dayStatistic);

        mockMvc.perform(
                post("/api/visit")
                        .param("userId", visitInfo.getUserId())
                        .param("siteUrl", visitInfo.getSiteUrl())
        ).andExpect(status().isOk())
                .andExpect(jsonPath("countOfVisiting").value(1))
                .andExpect(jsonPath("countUniqUsers").value(1));

        verify(visitService).getDayStatistic();
    }

    @Test
    void getPeriodStatistic() throws Exception{
        Date start = new Date();
        Date end = new Date();
        start.setYear(start.getYear() - 1);
        PeriodStatistic periodStatistic = new PeriodStatistic(1, 1, 0);
        when(visitService.getPeriodStatistic(start, end)).thenReturn(periodStatistic);
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        String startString = sdf.format(start);
        String endString = sdf.format(end);

        mockMvc.perform(
                get("/api/visit")
                        .param("start", startString)
                        .param("end", endString)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("countOfVisiting").value(1))
                .andExpect(jsonPath("countUniqUsers").value(1))
                .andExpect(jsonPath("countOfRegularUsers").value(0));

        verify(visitService).getPeriodStatistic(start, end);
        verifyNoMoreInteractions(visitService);
    }
}