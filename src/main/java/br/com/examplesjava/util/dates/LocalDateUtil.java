package br.com.examplesjava.util.dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Objects;

public class LocalDateUtil {

  private static final Locale localeBr = new Locale("pt", "BR");

  private static final DateTimeFormatter dateFormatterYearMonthDay =
      DateTimeFormatter.ofPattern("yyyyMMdd");

  private static final DateTimeFormatter dateFormatterHyphenDayMonthYear =
      DateTimeFormatter.ofPattern("dd-MM-yyyy");

  private static final DateTimeFormatter dateFormatterDayMonthYear =
      DateTimeFormatter.ofPattern("ddMMyyyy");

  private static final DateTimeFormatter dateFormatterYearMonth =
      DateTimeFormatter.ofPattern("yyyyMM");

  private static final DateTimeFormatter dateFormatterYearMonthDayTogether =
      DateTimeFormatter.ofPattern("yyyyMMddHHmm");

  private static final DateTimeFormatter dateFormatterYearMonthDayString =
      DateTimeFormatter.ofPattern("yyyy_MM_dd");

  private static final DateTimeFormatter dateFormatterMonthYear =
      DateTimeFormatter.ofPattern("MMM-yy", localeBr);

  public String convertForMonthYear(LocalDateTime date) {
    if (Objects.nonNull(date)) {
      DateTimeFormatter.ofPattern("").format(date);
      return dateFormatterMonthYear.format(date);
    }
    return null;
  }

  public String convertJoinYearMonthDay(LocalDateTime date) {
    if (Objects.nonNull(date)) {
      return dateFormatterYearMonthDay.format(date);
    }
    return null;
  }

  public static String convertJoinYearMon(LocalDateTime date) {
    if (Objects.nonNull(date)) {
      return dateFormatterYearMonth.format(date);
    }
    return null;
  }

  public String convertDateFormat(LocalDateTime date, String format) {
    if (Objects.nonNull(date)) {
      return DateTimeFormatter.ofPattern(format).format(date);
    }
    return null;
  }

  public String convertForYearMonthDayString(LocalDateTime date) {
    if (Objects.nonNull(date)) {
      return dateFormatterYearMonthDayString.format(date);
    }
    return null;
  }

  public String convertForHyphenDayMonthYearString(LocalDateTime date) {
    if (Objects.nonNull(date)) {
      return dateFormatterHyphenDayMonthYear.format(date);
    }
    return null;
  }

  public String convertForYearMonthDayTogether(LocalDateTime date) {
    if (Objects.nonNull(date)) {
      return dateFormatterYearMonthDayTogether.format(date);
    }
    return null;
  }

  public String convertForDayMontyYearTogether(LocalDateTime date) {
    if (Objects.nonNull(date)) {
      return dateFormatterDayMonthYear.format(date);
    }
    return null;
  }

  public String takeTheFistDayOfTheMonth(LocalDateTime date) {
    LocalDateTime localDateTime = date.with(TemporalAdjusters.firstDayOfMonth());
    return dateFormatterDayMonthYear.format(localDateTime);
  }

  public String takeTheLastDayOfTheMonth(LocalDateTime date) {
    LocalDateTime localDateTime = date.with(TemporalAdjusters.lastDayOfMonth());
    return dateFormatterDayMonthYear.format(localDateTime);
  }
}
