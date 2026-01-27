package com.codeforge.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * Main CLI entry point for the Model-Driven Backend Code Generator.
 * 
 * This is the root command that delegates to subcommands.
 */
@Command(name = "forge", mixinStandardHelpOptions = true, version = "1.0.0", description = "CodeForge - Generate Spring Boot projects from YAML models", subcommands = {
        GenerateCommand.class,
        ValidateCommand.class,
        CommandLine.HelpCommand.class
}, headerHeading = "%n", header = {
        "@|cyan ╔════════════════════════════════════════════════════════╗|@",
        "@|cyan ║     CODEFORGE BACKEND GENERATOR                       ║|@",
        "@|cyan ║     Lightweight Epsilon Transformation Pipeline       ║|@",
        "@|cyan ╚════════════════════════════════════════════════════════╝|@"
}, synopsisHeading = "%nUsage: ", descriptionHeading = "%nDescription:%n", parameterListHeading = "%nParameters:%n", optionListHeading = "%nOptions:%n", commandListHeading = "%nCommands:%n", footerHeading = "%n", footer = {
        "",
        "Examples:",
        "  forge generate blog.yaml -o ./my-api",
        "  forge validate healthcare.yaml",
        "  forge --version",
        "",
        "Documentation: https://github.com/codeforge/forge"
})
public class ForgeCli implements Callable<Integer> {

    @Option(names = { "-v",
            "--verbose" }, description = "Enable verbose output with detailed logging", scope = CommandLine.ScopeType.INHERIT)
    private boolean verbose;

    @Option(names = { "--no-color" }, description = "Disable ANSI color output", scope = CommandLine.ScopeType.INHERIT)
    private boolean noColor;

    /**
     * Entry point for the CLI application.
     */
    public static void main(String[] args) {
        System.exit(runCli(args));
    }

    /**
     * Run CLI and return exit code (for use by SpringGeneratorApp).
     */
    public static int runCli(String[] args) {
        // Detect if colors should be disabled
        boolean disableColors = System.getenv("NO_COLOR") != null ||
                System.console() == null;

        CommandLine cmd = new CommandLine(new ForgeCli())
                .setColorScheme(createColorScheme())
                .setUsageHelpWidth(80)
                .setExecutionExceptionHandler(new CliExceptionHandler());

        // Disable colors if environment doesn't support it
        if (disableColors) {
            cmd.setColorScheme(CommandLine.Help.defaultColorScheme(CommandLine.Help.Ansi.OFF));
        }

        return cmd.execute(args);
    }

    /**
     * Creates a custom color scheme for the CLI.
     */
    private static CommandLine.Help.ColorScheme createColorScheme() {
        return new CommandLine.Help.ColorScheme.Builder()
                .commands(CommandLine.Help.Ansi.Style.bold, CommandLine.Help.Ansi.Style.fg_cyan)
                .options(CommandLine.Help.Ansi.Style.fg_yellow)
                .parameters(CommandLine.Help.Ansi.Style.fg_yellow)
                .optionParams(CommandLine.Help.Ansi.Style.italic)
                .errors(CommandLine.Help.Ansi.Style.fg_red, CommandLine.Help.Ansi.Style.bold)
                .stackTraces(CommandLine.Help.Ansi.Style.italic)
                .build();
    }

    @Override
    public Integer call() throws Exception {
        // If no subcommand is specified, show help
        CommandLine.usage(this, System.out);
        return 0;
    }

    /**
     * Get verbose flag value (accessible to subcommands).
     */
    public boolean isVerbose() {
        return verbose;
    }

    /**
     * Get no-color flag value (accessible to subcommands).
     */
    public boolean isNoColor() {
        return noColor;
    }
}
